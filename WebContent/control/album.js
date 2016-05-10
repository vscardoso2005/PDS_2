var albumModule = angular.module('albumModule', []);

albumModule.controller("albumControl", function($scope, $http) {

	urlAlbum = 'http://localhost:8080/ProjetoDesenvolvimentoII/rs/album';
	
	urlArtista = 'http://localhost:8080/ProjetoDesenvolvimentoII/rs/artista';

	$scope.pesquisarAlbum = function() {
		$http.get(urlAlbum).success(function(albunsRetorno) {
			$scope.albuns = albunsRetorno;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.pesquisarArtista = function() {
		$http.get(urlArtista).success(function(artistasRetorno) {
			$scope.artistas = artistasRetorno;
		}).error(function(erro) {
			alert(erro);
		});
	}

	$scope.salvar = function() {
		if ($scope.album.codAlbum == '') {
			$http.post(urlAlbum, $scope.album).success(function(album) {
				$scope.albuns.push($scope.album);
				$scope.novo();
			}).error(function(erro) {
				alert(erro);
			});
		} else {
			$http.put(urlAlbum, $scope.album).success(function(album) {
				$scope.pesquisarAlbum();
				$scope.novo();
			}).error(function(erro) {
				alert(erro);
			});
		}
	}

	$scope.excluir = function() {
		if ($scope.album.codAlbum == '') {
			alert('Campo Vazio!!!');
		}else {
			urlExcluir = urlAlbum + "/" + $scope.album.codAlbum;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisarAlbum();
				$scope.novo();
			});
		}
	}

	$scope.novo = function() {
		$scope.album = "";
	}

	$scope.selecionaAlbum = function(album) {
		$scope.album = album;
	}

	$scope.selecionaArtista = function(artista) {
		$scope.album.artista = artista;
	}

	$scope.pesquisarAlbum();
	$scope.pesquisarArtista();
});