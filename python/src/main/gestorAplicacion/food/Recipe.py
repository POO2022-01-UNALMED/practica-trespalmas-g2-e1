from TypeRecipe import TypeRecipe as TyRe


class Recipe:
    total = 0

    def __int__(self, name, total=1, typeRecipe=TyRe.EJECUTIVO, ingredients=None):
        self.id = Recipe.total
        self.name = name
        self.total = total
        self.typeRecipe = typeRecipe
        self.ingredients = ingredients

        Recipe.total += 1
