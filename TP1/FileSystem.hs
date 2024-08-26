module FileSystem ( FileSystem, nuevoF, departamentosF, anunciosF, agregarAnuncioF, sacarAnuncioF, agregarDepartamentoF, sacarDepartamentoF, anunciosParaF )
 where
import Anuncio
import Tipos
   

data FileSystem = FS [Departamento] [Anuncio] deriving (Eq, Show)

   
nuevoF :: FileSystem                                              -- permite obtener un nuevo FileSystem
nuevoF  =  FS [] []
departamentosF :: FileSystem -> [ Departamento ]                  -- dado un FileSystem retorna los departamentos que incluye
departamentosF (FS departamentos _) = departamentos

anunciosF :: FileSystem -> [ Anuncio ]                            -- dado un FileSystem retorna los anuncios que incluye
anunciosF (FS _ anuncios) = anuncios 
    
  --consultar que debo conciderar como duplicado
agregarAnuncioF :: Anuncio -> FileSystem -> FileSystem            -- permite agregar un anuncio  
agregarAnuncioF anuncio (FS departamentos anuncios) 
        |anuncio `elem` anuncios = FS departamentos anuncios
        | otherwise = FS departamentos (anuncio:anuncios)

sacarAnuncioF :: Anuncio -> FileSystem -> FileSystem              -- permite eliminar un anuncio
sacarAnuncioF deleteAn (FS departamentos anuncios)
    | not (deleteAn `elem` anuncios) = FS departamentos anuncios 
    | otherwise = FS departamentos (filter (/= deleteAn) anuncios)

agregarDepartamentoF :: Departamento -> FileSystem -> FileSystem  -- permite agregar un departamento
agregarDepartamentoF addDept (FS departamentos anuncios)
    | addDept `elem` departamentos = FS departamentos anuncios  -- o dejar un mensaje de error (CONSULTAR)
    | otherwise = FS (addDept : departamentos) anuncios

-- Que pasa si el dep esta asociado a 2 anuncios? 
-- actualizar lista de los anuncios que estaban asoc a ese depto?
sacarDepartamentoF :: Departamento -> FileSystem -> FileSystem    -- permite eliminar un departamento
sacarDepartamentoF removeDep (FS departamentos anuncios)
    | not (removeDep `elem` departamentos) = FS departamentos anuncios  -- (lo mismo, CONSULTAR)
    | otherwise = FS (filter (/= removeDep) departamentos) anuncios
    
 
   anunciosParaF :: [Departamento] -> FilesSystem -> [Anuncio]        -- entrega los anuncios a emitir para un conjunto de departamentos
   anunciosParaF deptos (FS _ anuncios) = filter (aplicaA deptos) anuncios
