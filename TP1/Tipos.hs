module Tipos
    where
        import Data.Maybe
        import Data.List
        import Data.Char


        type Duracion = Int
        type Departamento = String
        type Nombre = String
        
yaExiste :: Eq a => a -> [a] -> Bool
yaExiste a xs = elem a xs
