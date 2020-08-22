using System.Diagnostics;
using Com.Example.Common.Attributes;
using Com.Example.Common.Services.Recipe;
using Com.Example.Game.Scripts.GameStartup;
using Godot;

public class HTTPButton : Button
{
    [InjectedProperty] private IRecipeService RecipeService { get; set; }

    public override void _Ready()
    {
        InjectedPropertyResolver.Resolve(this);
    }

    public void OnGetAllRecipes()
    {
        Debug.Assert(RecipeService != null, "RecipeService IS null");
        // RecipeService.GetAllRecipes();
    }
}