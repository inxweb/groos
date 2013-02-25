$.views.registerTags({ 
    dateFormat: function(value){ 
    	return Globalize.format( new Date(value), this.format); 
    },
	numberFormat: function(value){ 
		return Globalize.format(value, "n0"); 
	} 
}); 