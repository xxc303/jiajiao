function post() {
    var parentId = $("#teacher_id").val();
    var item = $("#item").val();
    var content = $("#comment_content").val();
    var overview = $("#overview").val();
    $.ajax({
        type:"post",
        url:"/comment",
        contentType:"application/json",
        data:JSON.stringify({
            "parentId":parentId,
            "item":item,
            "content":content,
            "overview":overview
        }),
        success:function (response) {
            console.log(response);
            if(response.code === 200)
            {
                window.location.reload();

            }else if (response.code === 500){
                alert("请先登录！");
            }else(response.code == 501)
            {
                alert(response.message);
            }
        },
        dataType:"json"
    });
    console.log(parentId);
}
function reserve() {
    var teacherId = $("#teacher_id").val();
    console.log(teacherId);
    $.ajax({
        type: "post",
        url: "/student/reserve",
        contentType: "application/json",
        data: JSON.stringify({
            "teacherId": teacherId,
        }),
        success: function (response) {
            console.log(response);
            if (response.code === 200) {
                window.location.reload();

            } else if (response.code === 500) {
                alert("请先登录！");
            }
        },
        dataType: "json"
    });
}
