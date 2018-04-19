myApp.controller("BlogController",
	function($scope,$http,$location)
	{
	$scope.blog={"blogName":'',"blogContent":'',"createDate":'',"likes":0,"userName":''}
	$scope.blogdata;
	$scope.insertBlog=function(){
		console.log('in blog insert method');
		$http.get('http://localhost:8082/whatsupmiddleware/demo1')
		//$http.post('http://localhost:8083/whatsupmiddleware/demo1',$scope.blog)
		.then(function(response){
			console.log('status text:'+response.statusText);
		})
	};
	}
);
