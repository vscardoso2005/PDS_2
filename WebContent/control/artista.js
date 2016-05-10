var artistaModule = angular.module('artistaModule', []);

artistaModule.controller("artistaControl", function($scope, $http) {

	urlArtista = 'http://localhost:8080/ProjetoDesenvolvimentoII/rs/artista';

	$scope.pesquisarArtista = function() {
		$http.get(urlArtista).success(function(artistasRetorno) {
			$scope.artistas = artistasRetorno;
		}).error(function(erro) {
			alert(erro);
		});
	}

	$scope.salvar = function() {
		if ($scope.artista.codArtista == '') {
			$http.post(urlArtista, $scope.artista).success(function(artista) {
				$scope.artistas.push($scope.artista);
				$scope.novo();
			}).error(function(erro) {
				alert(erro);
			});
		} else {
			$http.put(urlArtista, $scope.artista).success(function(artista) {
				$scope.pesquisarArtista();
				$scope.novo();
			}).error(function(erro) {
				alert(erro);
			});
		}
	}

	$scope.excluir = function() {
		if ($scope.artista.codArtista == '') {
			alert('Campo Vazio!!!');
		}else {
			urlExcluir = urlArtista + "/" + $scope.artista.codArtista;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisarArtista();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}

	}

	$scope.novo = function() {
		$scope.artista = "";
	}

	$scope.selecionaArtista = function(artista) {
		$scope.artista = artista;
	}

	$scope.pesquisarArtista();
});