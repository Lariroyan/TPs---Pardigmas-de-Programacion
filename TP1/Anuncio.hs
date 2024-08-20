module Anuncio (Anuncio, nuevoA, nombreA, duracionA, departamentosA, agregarA, sacarA, aplicaA )
  where
    import Data.Maybe
    import Data.List
    import Data.Char

    import Tipos

    data Anuncio = Anu Nombre [ Departamento ] Duracion deriving (Eq, Show, Ord)

    nuevoA :: Nombre -> Duracion -> Anuncio         -- dado un nombre y una duracion en segundos retorna un nuevo Anuncio
    nuevoA nombre duracion = Anu nombre [] duracion

    nombreA :: Anuncio -> Nombre                    -- dado un anuncio retorna su nombre
    nombreA (Anu nombre _ _) = nombre

    duracionA :: Anuncio -> Duracion                -- dado un anuncio retorna su duración
    duracionA (Anu _ _ duracion) = duracion

    departamentosA :: Anuncio -> [ Departamento ]   -- dado un anuncio retorna los departamentos que le fueron asociados
    departamentosA (Anu _ departamentos _) = departamentos

    agregarA :: Departamento -> Anuncio -> Anuncio -- permite asignar un departamento a un anuncio
    agregarA agregar_depto (Anu nombre departamento duracion)
        |yaExiste agregar_depto departamento = (Anu nombre departamento duracion)
        |otherwise =  Anu nombre (agregar_depto:departamento) duracion

    sacarA :: Departamento -> Anuncio -> Anuncio    -- permite quitarle un departamento a un anuncio
    sacarA sacar_depto (Anu nombre departamento duracion)
        |yaExiste sacar_depto departamento = Anu nombre (filter(/= sacar_depto) departamento) duracion
        |otherwise = (Anu nombre departamento duracion) --o un aviso para el usuario
        
    aplicaA :: [ Departamento ] -> Anuncio -> Bool  -- responde si un anuncion debe emitirse para alguno de los departamentos consultados
    aplicaA deptos (Anu _ departamentos _) = any (`elem` departamentos) deptos
