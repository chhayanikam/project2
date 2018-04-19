myApp.controller("TestController",
	function($scope,$http,$location)
	{
	$scope.test=function(){
		console.log('in test method');
		$http.get('http://localhost:8083/whatsupmiddleware/demo1')
		.then(function(response){
			alert("I am in "+response.statusText);
		console.log('status text:'+response.statusText);
		})
	};
	}
);
