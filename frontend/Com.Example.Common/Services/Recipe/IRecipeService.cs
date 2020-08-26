using System.Threading.Tasks;
using Com.Example.Demo.Protobuf.Recipe;

namespace Com.Example.Common.Services.Recipe
{
    public interface IRecipeService
    {
        void SaveRecipe();

        void GetRecipeWithId(int id);

        Task<RecipeResearchResponse> GetAllRecipes();
    }
}