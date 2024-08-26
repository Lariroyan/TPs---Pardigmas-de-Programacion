import Anuncio
import FileSystem
--import  Prompter 
import Tipos

-- Definición de Anuncios
anuncio1 = nuevoA "Anuncio1" 30
anuncio2 = nuevoA "Anuncio2" 45
anuncio3 = nuevoA "Anuncio3" 60

-- Agregar departamentos a los anuncios
anuncio1ConDepto = agregarA "Electrónica" anuncio1
anuncio2ConDepto = agregarA "Ropa" anuncio2
anuncio3ConDepto = agregarA "Hogar" anuncio3

-- Crear un FileSystem vacío
fileSystem1 = nuevoF

-- Agregar anuncios al FileSystem
fileSystem2 = agregarAnuncioF anuncio1ConDepto fileSystem1
fileSystem3 = agregarAnuncioF anuncio2ConDepto fileSystem2
fileSystem4 = agregarAnuncioF anuncio3ConDepto fileSystem3

-- Agregar departamentos al FileSystem
fileSystem5 = agregarDepartamentoF "Electrónica" fileSystem4
fileSystem6 = agregarDepartamentoF "Ropa" fileSystem5
fileSystem7 = agregarDepartamentoF "Hogar" fileSystem6

-- Tests para funciones de Anuncio
testAnuncio = [
    nombreA anuncio1 == "Anuncio1",
    duracionA anuncio2 == 45,
    departamentosA anuncio1ConDepto == ["Electrónica"],
    aplicaA ["Electrónica"] anuncio1ConDepto == True,
    aplicaA ["Ropa"] anuncio1ConDepto == False
    ]

-- Tests para funciones de FileSystem
testFileSystem = [
    departamentosF fileSystem7 == ["Hogar", "Ropa", "Electrónica"],
    anunciosF fileSystem4 == [anuncio3ConDepto, anuncio2ConDepto, anuncio1ConDepto],
    anunciosParaF ["Electrónica"] fileSystem7 == [anuncio1ConDepto]
    ]
-- Lista de todos los tests
allTests :: [Bool]
allTests = testAnuncio ++ testFileSystem
