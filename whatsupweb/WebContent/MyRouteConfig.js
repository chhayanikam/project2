//var app = angular.module("myApp",['ngRoute']);
var myApp = angular.module("myApp",['ngRoute',,'ngCookies']);
myApp.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "dashboard.html",controller: "TestController"
    })
    .when("/dashboard", {
        templateUrl : "dashboard.html",controller: "TestController"
    })
     .when("/displayBlogs", {
        templateUrl : "c_blog/displayBlogs.html"
    })
     .when("/addBlog", {
        templateUrl : "c_blog/addBlog.html",controller: "BlogController"
    })
     .when("/addForum", {
        templateUrl : "c_forum/addForum.html"
    })
     .when("/viewForum", {
        templateUrl : "c_forum/viewForum.html"
    })
     .when("/applyjob", {
        templateUrl : "c_job/applyjob.html"
    })
     .when("/updateprofile", {
        templateUrl : "c_user/updateprofile.html"
    })
    .when("/Register", {
        templateUrl : "c_user/Register.html"
    });
});
myApp.controller("TestController",
		function($scope,$http,$location)
		{
		$scope.test=function(){
			console.log('in test method');
			$http.get('http://localhost:8082/whatsupmiddleware/demo1')
			.then(function(response){
				alert("I am in "+response.statusText);
			console.log('status text:'+response.statusText);
			})
		};
		}
	);

myApp.run(function($rootScope,$cookieStore)
		{
			console.log('I am in run function');
			alert("main called");
			//console.log($rootScope.currentUser);
			
				/*if($rootScope.currentUser==undefined)
				{
				$rootScope.currentUser=$cookieStore.get('userDetails');
				}
				else
				{
				console.log($rootScope.currentUser.username);
				console.log($rootScope.currentUser.role);
				}*/
		});

