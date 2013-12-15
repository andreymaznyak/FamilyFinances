			$.ajax({
				type:'post',//тип запроса: get,post либо head
				url:'ajax.php',//url адрес файла обработчика
				async: false,
				success:function (json) {//возвращаемый результат от сервера
					$result = jQuery.parseJSON( json );
				}
			});

    

			$("#wijpiechart").wijpiechart({
				radius: 140,
				hint: {
					content: function () {
						return this.data.label + " : " + Globalize.format(this.value / this.total, "p2");
					}
				},
				header: {
					text: "Диаграмма доходов"
				},
				seriesList: result,
				seriesStyles: [{
					fill: "180-rgb(195,255,0)-rgb(175,229,0)", 
					stroke: "rgb(175,229,0)", 
					"stroke-width": 1.5
				}, {
					fill: "90-rgb(142,222,67)-rgb(127,199,60)", 
					stroke: "rgb(127,199,60)", 
					"stroke-width": 1.5
				}, {
					fill: "90-rgb(106,171,167)-rgb(95,153,150)", 
					stroke: "rgb(95,153,150)", 
					"stroke-width": 1.5
				}, {
					fill: "90-rgb(70,106,133)-rgb(62,95,119)", 
					stroke: "rgb(62,95,119)", 
					"stroke-width": 1.5
				}, {
					fill: "90-rgb(166,166,166)-rgb(149,149,149)", 
					stroke: "rgb(149,149,149)", 
					"stroke-width": 1.5
				}]
			});
