import Anuncio
import FileSystem
import  Prompter 
import Tipos
import Control.Exception
import System.IO.Unsafe

testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()

-- Definición de Anuncios
anuncio1 = nuevoA "Anuncio1" 30
anuncio2 = nuevoA "Anuncio2" 45
anuncio3 = nuevoA "Anuncio3" 60
anuncioDuplicado = nuevoA "Anuncio1" 30

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

testAnuncio = [
            -- testeos para Anuncio
            testF (nuevoA "" 30),
            testF (nuevoA "Anuncio" (-1)),
            nombreA anuncio1 == "Anuncio1",
            duracionA anuncio1 == 30,
            departamentosA anuncio1ConDepto == ["Electrónica"],
            testF (agregarA "" anuncio1),
            testF (agregarA "Electrónica" anuncio1ConDepto),
            testF (sacarA "" anuncio1),
            testF (sacarA "NoExiste" anuncio1),
            aplicaA ["Electrónica"] (agregarA "Dept" anuncio1ConDepto) == True,
            aplicaA ["NoExiste"] anuncio1 == False,
            aplicaA ["Electrónica"] anuncio1ConDepto == True,
            aplicaA ["Ropa"] anuncio1ConDepto == False,

            -- testeos para FileSystem
            anunciosParaF [] fileSystem7 == [],
            testF (sacarAnuncioF (nuevoA "NoExiste" 10) fileSystem7),
            testF (sacarDepartamentoF "NoExistente" fileSystem7 == fileSystem7),
            not (testF (agregarAnuncioF anuncioDuplicado fileSystem4)), 
            testF (sacarAnuncioF (nuevoA "Inexistente" 10) fileSystem4),  
            departamentosF fileSystem7 == ["Hogar", "Ropa", "Electrónica"],
            testF (departamentosF (agregarDepartamentoF "Electrónica" fileSystem7) == ["Hogar", "Ropa", "Electrónica"]),
            anunciosF fileSystem7 == [anuncio3ConDepto, anuncio2ConDepto, anuncio1ConDepto],
            anunciosF (sacarAnuncioF anuncio1ConDepto fileSystem7) == [anuncio3ConDepto, anuncio2ConDepto],
            anunciosParaF ["Hogar", "Electrónica"] fileSystem7 == [anuncio3ConDepto,anuncio1ConDepto],
            anunciosParaF ["NoExistente"] fileSystem7 == []
            ]
allTests :: [Bool]
allTests = testAnuncio
