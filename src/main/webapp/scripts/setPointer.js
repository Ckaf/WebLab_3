function getRValue() {
    return parseFloat($("span").text());
}

function drawPointsFromTable() {
    $("tbody tr").each(function () {
        let point = $(this);
        let x = parseFloat(point.find(">:first-child").text());
        let y = parseFloat(point.find(">:nth-child(2)").text());
        let r = getRValue();
        let result = point.find(">:nth-child(4)").text();
        if (isNaN(x) || isNaN(y)) {
            return;
        }
        let color;
        if (result.includes("Y")) {
            color = "green"
        } else if (result.includes("N")) {
            color = "red"
        } else {
            console.log("Oops")
        }

        function xValueForPoint(x) {
            return (x / r * 2 * 60 + 150)
        }

        function yValueForPoint(y) {
            return (-y / r * 2 * 60 + 150)
        }

        let plot = $("svg")

        let existingPlot = plot.html()
        let newPlot = `<circle id="pointer" r="5" cx="${xValueForPoint(x)}" cy="${yValueForPoint(y)}" fill-opacity="0.7" fill="${color}" stroke="firebrick" visibility="visible"></circle>`
        plot.html(existingPlot + newPlot)
    })
}


function getXFromSVG(x, r) {
    return (x - 150) / 60 / 2 * r;
}

function getYFromSVG(y, r) {
    return (y - 150) / 60 / 2 * -r;
}

function clickPlotHandler(e) {
    let offset = $(this).offset();
    let x = e.pageX - offset.left;
    let y = e.pageY - offset.top;

    let xValue = getXFromSVG(x, getRValue());
    let yValue = getYFromSVG(y, getRValue());


    $(".x-hidden").val(xValue);
    $(".y-hidden").val(yValue);
    $(".r-hidden").val(getRValue());
    $(".hidden-submit-btn").click();

}

$("svg").click(clickPlotHandler)
drawPointsFromTable()