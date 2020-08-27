using System;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Com.Example.Common.Attributes;
using Com.Example.Common.Services.Recipe;
using Com.Example.Demo.Protobuf.Recipe;
using Com.Example.Game.Scripts.GameStartup;
using Godot;

namespace Com.Example.Game.Scripts.TitleScreen.Buttons
{
    public class RecipeHTTPButton : Button
    {
        [InjectedProperty] private IRecipeService RecipeService { get; set; }

        public override void _Ready()
        {
            InjectedPropertyResolver.Resolve(this);
        }

        // It is absolutely fine to return void in this case, because this is the reaction to an event/signal in Godot
        public async void OnGetAllRecipes()
        {
            Debug.Assert(RecipeService != null, "RecipeService IS null");
            Task<RecipeResearchResponse> recipesTask = RecipeService.GetAllRecipes();
            await recipesTask.ContinueWith(PrintResult);
        }

        private void PrintResult(Task<RecipeResearchResponse> task)
        {
            task.Result.Recipes.ToList().ForEach(recipe => Console.WriteLine(recipe.ToString()));
        }
    }
}