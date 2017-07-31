var fs = require('fs');

fs.readdir("../public/file/",function(err, files){
    if (err) {
        return console.error(err);
    }
    files.forEach( function (file){
    	console.log(file);
    	fs.readFile("../public/file/"+file, function(err, data) {
    		   if (err) {
    		       return console.error(err);
    		   }
    		   console.log("文件异步读取成功！"+data);
    		   
    		   fs.appendFile('./merge.txt', data, function(err){
    	    	     if(err){
    	    	         console.log("文件写入失败")
    	    	     }else{
    	    	         console.log("文件写入成功");
    	    	     }
    		   })
    		   
    		   fs.appendFile('./merge.txt', "\n\n\n", function(err){
    	    	     if(err){
    	    	         console.log("文件写入换行失败")
    	    	     }else{
    	    	         console.log("文件写入换行成功");
    	    	     }
    		   })
    	    	
    	});
    });
});


