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
    
agregarAnuncioF :: Anuncio -> FileSystem -> FileSystem            -- permite agregar un anuncio  
agregarAnuncioF anuncio (FS departamentos anuncios) 
        |anuncio `elem` anuncios = error "El anuncio ya esta asociado al filesystem"
        | otherwise = FS departamentos (anuncio:anuncios)

sacarAnuncioF :: Anuncio -> FileSystem -> FileSystem              -- permite eliminar un anuncio
sacarAnuncioF deleteAn (FS departamentos anuncios)
    | not (deleteAn `elem` anuncios) = error "El anuncio no esta asociado al filesystem" 
    | otherwise = FS departamentos (filter (/= deleteAn) anuncios)

agregarDepartamentoF :: Departamento -> FileSystem -> FileSystem  -- permite agregar un departamento
agregarDepartamentoF addDept (FS departamentos anuncios)
    | addDept `elem` departamentos = error "El departamento ya esta en el FileSystem"  
    | otherwise = FS (addDept : departamentos) anuncios

sacarDepartamentoF :: Departamento -> FileSystem -> FileSystem    -- permite eliminar un departamento
sacarDepartamentoF removeDep (FS departamentos anuncios)
    | not (removeDep `elem` departamentos) = error "El departamento no esta en el FileSystem" 
    | otherwise = FS (filter (/= removeDep) departamentos) anuncios
    
 
 anunciosParaF :: [Departamento] -> FilesSystem -> [Anuncio]        -- entrega los anuncios a emitir para un conjunto de departamentos
 anunciosParaF deptos (FS _ anuncios) = filter (aplicaA deptos) anuncios
