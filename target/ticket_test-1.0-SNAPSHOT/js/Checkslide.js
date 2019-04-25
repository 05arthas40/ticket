function initmydrag() {
    //获取容器节点
    var dragContainer = document.getElementById("dragContainer");
    //获取拖动过程的颜色节点
    var dragBg = document.getElementById("dragBg");
    //获取文本节点
    var dragText = document.getElementById("dragText");
    //获取滑块节点
    var dragHandler = document.getElementById("dragHandler");
    //滑块最大偏移量(clientWidth:获取当前元素的宽度)
    //容器的宽度-滑块的宽度=滑块能滑动的距离
    var maxHandlerOffset = dragContainer.clientWidth - dragHandler.clientWidth;
    //初始化
    initDrag();
    function initDrag() {
        //设置初始文本信息
        dragText.textContent = "拖动滑块验证";
        /*为滑块添加点击事件（事件名称，调用的方法）
        mousedown:只需要按下即可触发（click需要按下并松开才可触发）
        touchstart：触摸事件（当手指触摸到的时候触发，一般用于手机和平板电脑）
         **/
        dragHandler.addEventListener("mousedown", onDragHandlerMouseDown);

        //dragHandler.addEventListener("touchstart", onDragHandlerMouseDown);
    }
    //事件参数event
    function onDragHandlerMouseDown(event){
        //鼠标指针在指定的元素中移动时，就会发生 mousemove 事件
        document.addEventListener("mousemove", onDragHandlerMouseMove);
        //鼠标离开时触发事件
        document.addEventListener("mouseup", onDragHandlerMouseUp);
    }
    function onDragHandlerMouseMove(event) {
        //event.clientX：鼠标移动的坐标
        //当前鼠标的横坐标(当前滑块初始的横坐标event.clientX大概是800多左右，必须要让它既大于0又必须小于最大值，才能滑动，要不然一触发事件就验证完了)
        var left = event.clientX-600 - dragHandler.clientWidth/2;
        if(left < 0){
            left = 0;
        } else if(left > maxHandlerOffset) {
            left = maxHandlerOffset;
            //验证成功
            verifySucc();
        }
        //滑块的坐标位置
        dragHandler.style.left = left + "px";
        //背景颜色的长度
        dragBg.style.width = dragHandler.style.left;
    }
    //当鼠标离开时调用，清除事件并将滑块和移动的颜色归位
    function onDragHandlerMouseUp(event) {
        document.removeEventListener("mousemove", onDragHandlerMouseMove);
        document.removeEventListener("mouseup", onDragHandlerMouseUp);
        dragHandler.style.left = 0;
        dragBg.style.width = 0;
    }
    //验证成功
    function verifySucc(){
        isVertifySucc = true;
        //success信息
        dragText.textContent = "验证通过";
        //颜色设置
        dragText.style.color = "wheat";
        //设置验证成功的属性
        dragHandler.setAttribute("class", "dragHandlerOkBg");
        //清空鼠标事件
        dragHandler.removeEventListener("mousedown", onDragHandlerMouseDown);
        document.removeEventListener("mousemove", onDragHandlerMouseMove);
        document.removeEventListener("mouseup", onDragHandlerMouseUp);

        //
         var btn = $("#login_btn");
         //移除原来的灰色背景
        btn.removeAttr("style");
        // //添加成功的背景
         btn.addClass("btn btn-success");
         //设置为可用
         btn.removeAttr("disabled");
    };
    if(window.parent != window){// 如果是在框架中
        //就让框架页面跳转到登陆页面
        window.parent.location.href = "login.html";
    }
}