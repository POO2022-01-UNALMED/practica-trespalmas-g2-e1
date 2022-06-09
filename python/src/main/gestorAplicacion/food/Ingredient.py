from TypeIngredient import TypeIngredient as TyIn


class Ingredient:
    total = 0

    def __int__(self, name, typeIngredient=TyIn.DEFAULT, storage=None):
        self.id = Ingredient.total
        self.typeIngredient = typeIngredient
        self.storage = storage
    