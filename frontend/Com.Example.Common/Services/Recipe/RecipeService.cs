using System;
using System.Linq;
using Com.Example.Demo.Protobuf.Recipe;
using Google.Protobuf.WellKnownTypes;
using Grpc.Core;

namespace Com.Example.Common.Services.Recipe
{
    class RecipeService : IRecipeService
    {
        public void SaveRecipe()
        {
            throw new NotImplementedException();
        }

        public void GetRecipeWithId(int id)
        {
            throw new NotImplementedException();
        }

        public void GetAllRecipes()
        {
            // TODO: the channel should be opened once I guess...
            Channel channel = new Channel("127.0.0.1:6565", ChannelCredentials.Insecure);
            var client = new global::RecipeService.RecipeServiceClient(channel);

            RecipeResearchResponse recipes = client.FindAll(new Empty());
            recipes.Recipes.ToList().ForEach(dto => Console.WriteLine(dto.Name));

            channel.ShutdownAsync().Wait();
        }
    }
}