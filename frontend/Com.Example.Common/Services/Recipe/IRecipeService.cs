namespace Com.Example.Common.Services.Recipe
{
    public interface IRecipeService
    {
        void SaveRecipe();

        void GetRecipeWithId(int id);

        void GetAllRecipes();
    }
}