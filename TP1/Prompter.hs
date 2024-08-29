module Prompter ( Prompter, nuevoP, archivosR, departamentosP, configurarP, anunciosP, showP, avanzarP, duracionP )
    where

    import Tipos
    import Anuncio
    import FilesSystem

    data Prompter = Pro FilesSystem  [Departamento] Int deriving (Eq, Show)

nuevoP :: FilesSystem -> Prompter                       -- permite obtener un nuevo Prompter en base a un FileSystem
nuevoP fs = Pro fs [] 0
    
archivosR :: Prompter -> FilesSystem                    -- dado un prompter retorna su fileSystem
archivosR (Pro fs _ _) = fs

departamentosP :: Prompter -> [Departamento]           -- dado un prompter retorna sus departamentos
departamentosP (Pro _ departamentos _) = departamentos

configurarP :: Prompter -> [Departamento] -> Prompter  -- Prepara el prompter para emitir los anuncios en los departementos indicados
configurarP (Pro fs _ idx) nuevosDeps = Pro fs nuevosDeps idx

anunciosP :: Prompter ->  [Nombre]                      -- entrega la lista de nombres de anuncios configurados
anunciosP (Pro fs deptos _) = let anuncios = anunciosF fs in [nombreA a | a <- anuncios, aplicaA deptos a]

showP :: Prompter -> Anuncio                           -- muestra el anuncio actual 
showP (Pro fs deptos index) 
        | null validAnuncios = error "No hay anuncios válidos para los departamentos configurados"
        | index < 0 || index >= length validAnuncios = error "Índice fuera de rango"
        | otherwise = validAnuncios !! index
         where
             anuncios = anunciosF fs
             validAnuncios = filter (aplicaA deptos) anuncios
    
avanzarP :: Prompter -> Prompter                       -- pasa al siguiente anuncio
avanzarP (Pro fs deptos index) 
    | len == 0 = error "No hay anuncios válidos para los departamentos configurados"
    | otherwise = Pro fs deptos newIndex
        where
            validAnuncios = filter (aplicaA deptos) (anunciosF fs)
            len = length validAnuncios
            newIndex = (index + 1) `mod` len
duracionP :: Prompter -> Duracion                      -- indica la duracion total de los anuncios configurados  
duracionP (Pro fs deptos _) = sum (map duracionA validAnuncios)
     where
      validAnuncios = filter (aplicaA deptos) (anunciosF fs)
