(function (win, doc) {
  var el = null
  var canvas = null
  var ctx = null
  var cacheCanvas = doc.createElement('canvas')
  var cacheCtx = cacheCanvas.getContext('2d')
  var thumbCanvas = doc.createElement('canvas')
  var thumbCtx = thumbCanvas.getContext('2d')
  var thumbW = 150
  var thumbH = 150
  var mask = {
    x: 0,
    y: 0,
    w: thumbW,
    h: thumbH,
    sx: 0,
    sy: 0,
    sw: 0,
    sh: 0
  }
  var resize = {
    w: 6,
    h: 6
  }
  var disX = 0
  var disY = 0
  var image = null
  var action = ''
  var locked = true
  var start = false
  var preview = null
  var saveBtn = null
  var thumbBase64 = ''
  var api = {}

  var base2blob = function (base64) {
    var format = 'image/png'
    var base64 = base64
    var code = window.atob(base64.split(',')[1])
    var aBuffer = new window.ArrayBuffer(code.length)
    var uBuffer = new window.Uint8Array(aBuffer)
    
    for(var i = 0; i < code.length; i++){
      uBuffer[i] = code.charCodeAt(i) & 0xff
    }

    var blob = null
    
    try {
      blob = new Blob([uBuffer], { type: format })
    } catch (e) {
      window.BlobBuilder = window.BlobBuilder ||
      window.WebKitBlobBuilder ||
      window.MozBlobBuilder ||
      window.MSBlobBuilder;

      if (e.name == 'TypeError' && window.BlobBuilder) {
        var bb = new window.BlobBuilder()
        
        bb.append(uBuffer.buffer)

        blob = bb.getBlob('image/png')
      } else if (e.name === 'InvalidStateError') {
        blob = new Blob([aBuffer], { type: format })
      } else {
      }
    }
    
    return blob
  }

  var dataURLtoBlob = function (dataurl) {
    var arr = dataurl.split(','), mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n)
    
    while (n--) {
      u8arr[n] = bstr.charCodeAt(n)
    }
    
    return new Blob([u8arr], { type: mime })
  }

  var onSaveClick = function () {
    if (thumbBase64 === '') {
      alert('请选择一张图片')

      return false
    }

    var blobData = dataURLtoBlob(thumbBase64)

    fetch(api.save, {
      method: 'POST',
      mode: 'no-cors',
      body: blobData
    })
    .then(res => res.text())
    .then(res => {
      console.log(res)
      alert('上传成功')
    })
  }

  var getThumbImageData = function (backgroundColor) {
    thumbCtx.clearRect(0, 0, thumbCanvas.width, thumbCanvas.height)

    if (backgroundColor) {
      thumbCtx.fillStyle = backgroundColor

      thumbCtx.fillRect(0, 0, thumbCanvas.width, thumbCanvas.height)
    }

    thumbCtx.drawImage(canvas, mask.x, mask.y, mask.w, mask.h, 0, 0, thumbW, thumbH)

    return thumbCanvas.toDataURL('image/png')
  }

  var getMaskImageData = function (options) {
    cacheCtx.clearRect(0, 0, cacheCanvas.width, cacheCanvas.height)

    cacheCtx.fillStyle = 'rgba(0, 0, 0, .5)'

    cacheCtx.fillRect(0, 0, cacheCanvas.width, cacheCanvas.height)

    cacheCtx.clearRect(options.x, options.y, options.w, options.h)

    cacheCtx.strokeStyle = 'rgba(244, 33, 85, .8)'
    cacheCtx.strokeWidth = 1
    cacheCtx.strokeRect(options.x, options.y, options.w, options.h)
    
    cacheCtx.fillStyle = 'rgba(244, 33, 85, .8)'

    cacheCtx.fillRect(options.x - resize.w / 2, options.y - resize.h / 2, resize.w, resize.h)
    cacheCtx.fillRect(options.x + options.w - resize.w / 2, options.y - resize.h / 2, resize.w, resize.h)
    cacheCtx.fillRect(options.x + options.w - resize.w / 2, options.y + options.h - resize.h / 2, resize.w, resize.h)
    cacheCtx.fillRect(options.x - resize.w / 2, options.y + options.h - resize.h / 2, resize.w, resize.h)

    return cacheCanvas
  }

  var renderCanvas = function (options) {
    ctx.clearRect(0, 0, canvas.width, canvas.height)

    var tx = 0
    var ty = 0
    var tw = image.width
    var th = image.height
    var ratio = tw / th

    if (tw > canvas.width) {
      tw = canvas.width
      th = tw / ratio
    }

    if (th > canvas.height) {
      th = canvas.height
      tw = th * ratio
    }

    tx = Math.round(canvas.width - tw) / 2
    ty = Math.round(canvas.height - th) / 2

    ctx.drawImage(image, 0, 0, image.width, image.height, tx, ty, tw, th)

    preview.src = getThumbImageData('#fff')

    thumbBase64 = preview.src

    ctx.drawImage(getMaskImageData(mask), 0, 0, canvas.width, canvas.height)
  }

  var loadBase64 = function (base64) {
    image = new Image()

    image.onload = function () {
      mask.w = thumbW
      mask.h = thumbH
      mask.x = Math.round(canvas.width - mask.w) / 2
      mask.y = Math.round(canvas.height - mask.h) / 2

      renderCanvas({
        x: mask.x,
        y: mask.y
      })
    }

    image.src = base64
  }

  var onFileChange = function (ev) {
    var file = this.files[0]
    var reader = new FileReader()
    var upload = el.querySelector('.dm-crop-upload')

    upload.className = 'dm-crop-upload dm-crop-upload_hide'

    reader.onload = function () {
      base64 = this.result

      loadBase64(base64)
    }

    reader.readAsDataURL(file)
  }

  var position = function (element) {
    var result = {
      x: 0,
      y: 0
    }

    while (element) {
      result.x += element.offsetLeft
      result.y += element.offsetTop

      element = element.offsetParent
    }

    return result
  }

  var collision = function (x1, y1, w1, h1, x2, y2, w2, h2) {
    if ((x1 + w1 < x2) || (x1 > x2 + w2) || (y1 + h1 < y2) || (y1 > y2 + h2)) {
      return false
    } else {
      return true
    }
  }

  var onCanvasMousemove = function (ev) {
    if (start) {
      return false
    }

    action = ''
    canvas.classList.remove('dm-crop-canvas_hover')
    canvas.classList.remove('dm-crop-canvas_resize-nw')
    canvas.classList.remove('dm-crop-canvas_resize-ne')
    canvas.classList.remove('dm-crop-canvas_resize-se')
    canvas.classList.remove('dm-crop-canvas_resize-sw')

    var scrollTop = doc.documentElement.scrollTop || doc.body.scrollTop

    var cx = ev.clientX - position(canvas).x
    var cy = ev.clientY - position(canvas).y + scrollTop

    if (collision(
        cx, 
        cy, 
        0, 
        0, 
        mask.x - resize.w / 2, 
        mask.y - resize.h / 2, 
        resize.w, 
        resize.h) && action === '') {
      action = 'resize-nw'
      canvas.classList.add('dm-crop-canvas_resize-nw')
    } else if (collision(
        cx, 
        cy, 
        0, 
        0, 
        mask.x + mask.w - resize.w / 2, 
        mask.y - resize.h / 2, 
        resize.w, 
        resize.h)) {
      action = 'resize-ne'
      canvas.classList.add('dm-crop-canvas_resize-ne')
    } else if (collision(
        cx, 
        cy, 
        0, 
        0, 
        mask.x + mask.w - resize.w / 2, 
        mask.y + mask.h - resize.h / 2, 
        resize.w, 
        resize.h)) {
      action = 'resize-se'
      canvas.classList.add('dm-crop-canvas_resize-se')
    } else if (collision(
        cx, 
        cy, 
        0, 
        0, 
        mask.x - resize.w / 2, 
        mask.y + mask.h - resize.h / 2, 
        resize.w, 
        resize.h)) {
      action = 'resize-sw'
      canvas.classList.add('dm-crop-canvas_resize-sw')
    } else if (collision(cx, cy, 0, 0, mask.x, mask.y, mask.w, mask.h)) {
      action = 'move'
      canvas.classList.add('dm-crop-canvas_hover')
    }
  }

  var onDocMousemove = function (ev) {
    if (!start) {
      return false
    }

    if (action === 'move') {
      mask.x = ev.clientX - position(canvas).x - disX
      mask.y = ev.clientY - position(canvas).y - disY

      canvas.classList.add('dm-crop-canvas_move')
    }

    if (action === 'resize-nw') {
      if (locked) {
        mask.x = mask.sx + (ev.clientX - position(canvas).x - disX - mask.sx)
        mask.y = mask.sy + (ev.clientX - position(canvas).x - disX - mask.sx)
        mask.w = mask.sw + (mask.sx - mask.x)
        mask.h = mask.sh + (mask.sy - mask.y)
      } else {
        mask.x = mask.sx + (ev.clientX - position(canvas).x - disX - mask.sx)
        mask.y = mask.sy + (ev.clientY - position(canvas).y - disY - mask.sy)
        mask.w = mask.sw + (mask.sx - mask.x)
        mask.h = mask.sh + (mask.sy - mask.y)
      }
    }

    if (action === 'resize-ne') {
      if (locked) {
        mask.y = mask.sy - (ev.clientX - position(canvas).x - disX - mask.sx)
        mask.w = mask.sw + (ev.clientX - position(canvas).x - disX - mask.sx)
        mask.h = mask.sh + (ev.clientX - position(canvas).x - disX - mask.sx)
      } else {
        mask.y = mask.sy + (ev.clientY - position(canvas).y - disY - mask.sy)
        mask.w = mask.sw + (ev.clientX - position(canvas).x - disX - mask.sx)
        mask.h = mask.sh + (mask.sy -mask.y)
      }
    }

    if (action === 'resize-se') {
      if (locked) {
        mask.w = mask.sw + (ev.clientX - position(canvas).x - disX - mask.sx)
        mask.h = mask.sh + (ev.clientX - position(canvas).x - disX - mask.sx)
      } else {
        mask.w = mask.sw + (ev.clientX - position(canvas).x - disX - mask.sx)
        mask.h = mask.sh + (ev.clientY - position(canvas).y - disY - mask.sy)
      }
    }

    if (action === 'resize-sw') {
      if (locked) {
        mask.x = mask.sx + (ev.clientX - position(canvas).x - disX - mask.sx)
        mask.w = mask.sw + (mask.sx - mask.x)
        mask.h = mask.sh + (mask.sx - mask.x)
      } else {
        mask.x = mask.sx + (ev.clientX - position(canvas).x - disX - mask.sx)
        mask.w = mask.sw + (mask.sx - mask.x)
        mask.h = mask.sh + (ev.clientY - position(canvas).y - disY - mask.sy)
      }
    }

    if (mask.w < 0) {
      mask.w = 0
    }

    if (mask.h < 0) {
      mask.h = 0
    }

    renderCanvas({
      x: mask.x,
      y: mask.y
    })
  }

  var onDocMouseup = function (ev) {
    doc.removeEventListener('mousemove', onDocMousemove, false)
    doc.removeEventListener('mouseup', onDocMouseup, false)

    canvas.classList.remove('dm-crop-canvas_move')

    action = ''

    start = false
  }

  var onCanvasMousedown = function (ev) {
    disX = ev.clientX - position(canvas).x - mask.x
    disY = ev.clientY - position(canvas).y - mask.y

    start = true
    
    mask.sx = mask.x
    mask.sy = mask.y
    mask.sw = mask.w
    mask.sh = mask.h

    doc.addEventListener('mousemove', onDocMousemove, false)
    doc.addEventListener('mouseup', onDocMouseup, false)
  }

  var Crop = function (options) {
    el = options.el
    preview = el.querySelector('.dm-crop-preview__image')
    saveBtn = el.querySelector('.dm-crop-btn__save')

    api = options.data.api
    
    var pickers = el.querySelectorAll('.dm-crop-btn__upload input')

    if (options.data.preview) {
      preview.src = options.data.preview
    }

    canvas = el.querySelector('.dm-crop-canvas')
    ctx = canvas.getContext('2d')

    cacheCanvas.width = canvas.width
    cacheCanvas.height = canvas.height
    
    thumbCanvas.width = thumbW
    thumbCanvas.height = thumbH

    canvas.addEventListener('mousedown', onCanvasMousedown, false)
    canvas.addEventListener('mousemove', onCanvasMousemove, false)

    saveBtn.addEventListener('click', onSaveClick, false)

    for (var i = 0, len = pickers.length; i < len; i++) {
      (function (index) {
        pickers[index].addEventListener('change', onFileChange, false)
      })(i)
    }
  }

  window.Crop = Crop
})(window, document)