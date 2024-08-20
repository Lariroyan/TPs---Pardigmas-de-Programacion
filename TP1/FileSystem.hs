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
    agregarAnuncioF (FS departamentos anuncios) = FS departamentos (anuncio:anuncios)
    
    sacarAnuncioF :: Anuncio -> FileSystem -> FileSystem              -- permite eliminar un anuncio
    agregarDepartamentoF :: Departamento -> FileSystem -> FileSystem  -- permite agregar un departamento
    sacarDepartamentoF :: Departamento -> FileSystem -> FileSystem    -- permite eliminar un departamento
    anunciosParaF :: [Departamento] -> FileSystem -> [Anuncio]        -- entrega los anuncios a emitir para un conjunto de departamentos
