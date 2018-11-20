var minhaLoja = angular.module("minhaLoja", []);

minhaLoja.controller('lojaCtrl',function ($scope){

	$scope.titulo = "Mini PÉgada";
	$scope.produtos = [
	{nome: "Sapato Cinderela", preco: "119,00", imagem: "img/sapato1.png" },
	{nome: "Sapato Familia Addams" , preco: "130,00" , imagem: "img/sapato3.jpg"},
	{nome: "Sapato Uma Linda Mulher", preco: "99,00", imagem: "img/sapato2.jpg"}
	];	

	$scope.incluirProduto = function (produto) {
		$scope.produtos.push(produto);
		delete $scope.produto; //apaga o que inseriu
	}
});