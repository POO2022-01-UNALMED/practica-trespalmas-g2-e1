from Ingredient import Ingredient
from TypeIngredient import TypeIngredient as TyIn


class CoolIngredient(Ingredient):
    total = 0

    def __int__(self, name, typeIngredient=TyIn.DEFAULT, storage=None):
        super().__int__(name, typeIngredient, storage)
