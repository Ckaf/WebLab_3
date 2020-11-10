function drawPointsFromTable() {
    $("tbody tr").each(function () {
        let point = $(this);
        let x = parseFloat(point.find(">:first-child").text());
        let y = parseFloat(point.find(">:nth-child(2)").text());
        let r = parseFloat(point.find(">:nth-child(3)").text());
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

        function xFromSVG(x) {
            return (x / r * 2 * 60 + 150)
        }

        function yFromSVG(y) {
            return (-y / r * 2 * 60 + 150)
        }

        let plot = $("svg")
        let existingPlot = plot.html()
        let newPlot = `<circle id="pointer" r="5" cx="${xFromSVG(x)}" cy="${yFromSVG(y)}" fill-opacity="0.7" fill="${color}" stroke="firebrick" visibility="visible"></circle>`
        plot.html(existingPlot + newPlot)
    })
}

drawPointsFromTable()