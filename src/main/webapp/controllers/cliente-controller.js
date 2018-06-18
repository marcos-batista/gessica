angular.module('GessicaVendasApp').controller('ClienteController', ClienteController);
ClienteController.$inject = ['$scope', '$http'];

function ClienteController($scope, $http)
{
	//var applicationHost = 'http://localhost:8080';						//------>>>>> DEV
	var applicationHost = 'https://gessica-module-vendas.herokuapp.com/';	//------>>>>> PRD
	var defaultHeaders = [{'content-type': 'application/json'}];
	
	$scope.clientes = [];
	$scope.cliente = {};
	
	var mountUrl = function(resource){
		return (applicationHost + '/' + resource);
	};
	
	var resetCliente = function(){
		$scope.cliente = {};
	}
	
	var listClientes = function ()
	{
		$http({
			method : 'GET',
			url : mountUrl('clientes'),
			headers : defaultHeaders
		})
		.then(
			function(response){
				$scope.clientes = response.data;
			}
		);
	};
	
	var factotryCliente = function()
	{
		$http({
			method : 'GET',
			url : mountUrl('cliente'),
			headers : defaultHeaders
		})
		.then(
			function(response){
				$scope.cliente = response.data;
			}
		);
	};
	
	var saveCliente = function () {
		$http({
			method : 'POST',
			url : mountUrl('cliente'),
			headers : defaultHeaders,
			data : $scope.cliente
		})
		.then(function(response){
			Console.log("Cliente saved successfuly!");
			Console.log(response.data);
		});
		
		loadApp();
		
	};
	
	var updateCliente = function (cliente){};
	
	var deleteCliente = function (cliente){};
	
	var loadApp = function(){
		factotryCliente();
		listClientes();
	};
	
	loadApp();
	
	
}