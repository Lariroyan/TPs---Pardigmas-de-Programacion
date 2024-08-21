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
agregarA addDept (Anu nombre departamento duracion)
    | null addDept = error "El departamento no puede ser una cadena vacia"
    | elem addDept departamento = error "El departamento ya esta asociado con el anuncio"
    | otherwise = Anu nombre (addDept: departamento) duracion

sacarA :: Departamento -> Anuncio -> Anuncio    -- permite quitarle un departamento a un anuncio
sacarA removeDept (Anu nombre departamento duracion)
    | null removeDept = error "El departamento no puede ser una cadena vacia"
    | not (elem removeDept departamento) = error "El departamento no esta asociado con el anuncio"
    | otherwise = Anu nombre (filter (/= removeDept) departamento) duracion

aplicaA :: [ Departamento ] -> Anuncio -> Bool  -- responde si un anuncion debe emitirse para alguno de los departamentos consultados
aplicaA deptos anuncio = any (`elem` deptos) (departamentosA anuncio)
