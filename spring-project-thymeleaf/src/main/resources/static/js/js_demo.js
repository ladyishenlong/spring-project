function hello() {
    console.log("执行该方法");
    document.getElementById("p_showData").innerText = "hello javaScript";
}


function getAjaxData(value) {
    console.log("----开始网络请求----")
    $.ajax({
        url: "/js/getAjaxData",
        contentType: "application/json;charset=UTF-8",
        type: "GET",
        data: {value: value},
        success: function (data) {
            console.log(data)
        },
        error: function () {
            console.log("请求异常")
        }
    })
}

let listData = {
    "name": "阿尔托莉雅",
    "power": "誓约胜利之剑"
};


function addOneData() {
    console.log("添加单个数据");
    var rowTr = document.createElement('tr');//创建标签
    var child = "<td>" + listData.name + "</td>" +
        "<td>" + listData.power + "</td>";
    rowTr.innerHTML = child;//填充tr标签的内容
    $(".tbody").append(rowTr)
}


function addListData() {
    let list = [];
    list.push(listData);
    list.push(listData);
    list.push(listData);
    console.log("数组的长度："+list.length);

    for (let listElement of list) {
        console.log("这个是"+listElement.power)
        var rowTr = document.createElement('tr');//创建标签
        var child = "<td>" + listElement.name + "</td>" +
            "<td>" + listElement.power + "</td>";
        rowTr.innerHTML = child;//填充tr标签的内容
        $(".tbody").append(rowTr)
    }


}