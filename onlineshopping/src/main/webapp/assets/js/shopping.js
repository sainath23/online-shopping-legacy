$(document).ready(function(){
	
	// Solution to active menu problem
	switch(menu) {
		case "About Us":
			$("#about").addClass("active");
			break;
		case "Contact Us":
			$("#contact").addClass("active");
			break;
		case "All Products":
			$("#listProducts").addClass("active");
			break;
		default:
			if(menu == "Home")
				break;
			$("#listProducts").addClass("active");
			$("#a_"+menu).addClass("active");
			break;
	}
	
	// Code for jquery datatables
	var table = $('#product_list_table');
	if(table.length) {
		//console.log('Inside table!');
		var jsonUrl = '';
		if(window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else {
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}
		table.DataTable({
			order: [],
		    columnDefs: [ {
		      targets  : 'no-sort',
		      orderable: false,
		    }],
			lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'All']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
			          {
			        	  data: 'code',
			        	  bSortable: false,
			        	  mRender: function(data, type, row) {
			        		  return '<img src="' + window.contextRoot + '/resources/images/' + data + '.png" class="dataTableImg" />';
			        	  }
			          },
			          {
			        	  data: 'name'
			          },
			          {
			        	  data: 'brand'
			          },
			          {
			        	  data: 'unitPrice',
			        	  mRender: function(data, type, row) {
			        		  return '&#8377; ' + data;
			        	  }
			          },
			          {
			        	  data: 'quantity',
			        	  mRender: function(data, type, row) {
			        		  if(data < 1) {
			        			  return '<span style="color:red">Out of Stock!</span>';
			        		  }
			        		  return data;
			        	  }
			          },
			          {
			        	  data: 'id',
			        	  bSortable: false,
			        	  mRender: function(data, type, row) {
			        		  var url = '';
			        		  url += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
			        		  
			        		  if(row.quantity < 1) {
			        			  url += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
			        		  }
			        		  else {
			        			  url += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
			        		  }
			        		  return url;
			        	  }
			          }
			          ]
		});
	}
});