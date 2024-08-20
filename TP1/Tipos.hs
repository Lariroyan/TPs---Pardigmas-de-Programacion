module Tipos
    where
        import Data.Maybe
        import Data.List
        import Data.Char


        type Duracion = Int
        type Departamento = String
        type Nombre = String
        
duplicado :: Eq a => a -> [a] -> Bool
duplicado a xs = elem a xs
