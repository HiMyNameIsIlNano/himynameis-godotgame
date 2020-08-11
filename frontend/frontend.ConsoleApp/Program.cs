using System;
using System.Collections.Generic;
using System.Linq;
using Com.Example.Demo.Protobuf.Recipe;
using Google.Protobuf.WellKnownTypes;
using Grpc.Core;

namespace frontend.ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Channel channel = new Channel("127.0.0.1:6565", ChannelCredentials.Insecure);


            var client = new RecipeService.RecipeServiceClient(channel);
            
            Console.WriteLine("Empty DB");
            client.RemoveAllRecipes(new Empty());
            
            Console.WriteLine("Init recipes");
            RecipeInitRequest recipeInitRequest = new RecipeInitRequest {Amount = 5};
            client.Init(recipeInitRequest);

            Console.WriteLine("Getting all recipes");
            List<RecipeDTO> recipeDtos = getRecipes(client);
            recipeDtos.ForEach(dto => Console.WriteLine(dto.Name));
            
            Console.WriteLine("Remove a recipe");
            RecipeDTO aRecipeDto = recipeDtos[0];
            RecipeRemoveRequest recipeRemoveRequest = new RecipeRemoveRequest {Name = aRecipeDto.Name};
            
            client.RemoveRecipe(recipeRemoveRequest);

            Console.WriteLine("Getting remaining recipes");
            List<RecipeDTO> afterDeletion = getRecipes(client);
            afterDeletion.ForEach(dto => Console.WriteLine(dto.Name));
            
            channel.ShutdownAsync().Wait();
        }

        private static List<RecipeDTO> getRecipes(RecipeService.RecipeServiceClient client)
        {
            RecipeResearchResponse recipes = client.FindAll(new Empty());
            List<RecipeDTO> recipeDtos = recipes.Recipes.ToList();
            return recipeDtos;
        }
    }
}