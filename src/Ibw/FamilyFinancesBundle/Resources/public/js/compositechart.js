$.ajax({
			type:'post',//тип запроса: get,post либо head
			url:'/pieinfouserincome',//url адрес файла обработчика
			async: false,
			success:function (json) {//возвращаемый результат от сервера
				result = $.parseJSON( json );
			}
		});

$("#wijcompositechart").wijcompositechart({
	axis: {
		y: {text: "Total Hardware"},
		x: {text: ""}
	},
	hint: {
		content: function () {return this.label + '\n ' + this.y + '';}
	},
	header: {text: "Состояние фондов"},
	seriesList: [{
		type: "column",
		label: "West",
		data: { 
			x: ['Desktops', 'Notebooks', 'AIO', 'Tablets', 'Phones'], 
			y: [5, 3, 4, 7, 2] }
	}, {
		type: "column",
		label: "Central",
		data: { 
			x: ['Desktops', 'Notebooks', 'AIO', 'Tablets', 'Phones'], 
			y: [2, 2, 3, 2, 1] }
	}, {
		type: "column",
		label: "East",
		data: { 
			x: ['Desktops', 'Notebooks', 'AIO', 'Tablets', 'Phones'], 
			y: [3, 4, 4, 2, 5] }
	}, {
		type: "pie",
		label: "asdfdsfdsf",
		center: { x: 150, y: 150 },
		radius: 60,
		data: [
			{label: "MacBook Pro",data: 46.78}, 
			{label: "iMac", data: 23.18}, 
			{label: "MacBook", data: 20.25}
		]
	}, {
		type: "line",
		label: "Steam1",
		data: {
			x: ['Desktops', 'Notebooks', 'AIO', 'Tablets', 'Phones'],
			y: [3, 6, 2, 9, 5]
		},
		markers: {visible: true, type: "circle"}
	}, {
		type: "line",
		label: "Steam2",
		data: {
			x: ['Desktops', 'Notebooks', 'AIO', 'Tablets', 'Phones'],
			y: [1, 3, 4, 7, 2]
		},
		markers: {visible: true, type: "tri"}
	}]
});
    