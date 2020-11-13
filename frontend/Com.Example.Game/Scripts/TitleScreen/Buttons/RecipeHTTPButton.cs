using System;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Com.Example.Common.Attributes;
using Com.Example.Common.Network.Protobuf.Planet;
using Com.Example.Common.Services.Planet;
using Com.Example.Game.Scripts.GameStartup;
using Godot;

namespace Com.Example.Game.Scripts.TitleScreen.Buttons
{
    public class RecipeHTTPButton : Button
    {
        [InjectedProperty] private IPlanetService PlanetService { get; set; }

        public override void _Ready()
        {
            InjectedPropertyResolver.Resolve(this);
        }

        // It is absolutely fine to return void in this case, because this is the reaction to an event/signal in Godot
        public async void OnGetAllPlanets()
        {
            Debug.Assert(PlanetService != null, "RecipeService IS null");
            Task<PlanetResearchResponse> missions = PlanetService.GetAllMissions();
            await missions.ContinueWith(PrintResult);
        }

        private void PrintResult(Task<PlanetResearchResponse> task)
        {
            task.Result.Planets.ToList().ForEach(recipe => Console.WriteLine(recipe.ToString()));
        }
    }
}