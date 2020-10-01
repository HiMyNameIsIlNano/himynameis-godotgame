using System;
using System.Threading.Tasks;
using Com.Example.Common.Services.Protobuf;
using Com.Example.Common.Services.Protobuf.Grpc;
using Com.Example.Demo.Protobuf.Recipe;
using Google.Protobuf.WellKnownTypes;
using Grpc.Core;
using static RecipeGrpcService;

namespace Com.Example.Common.Services.Recipe
{
    class RecipeService : IRecipeService
    {
        private readonly IGrpcChannelService _grpcChannelService;
        
        public RecipeService(IGrpcChannelService grpcChannelService)
        {
            _grpcChannelService = grpcChannelService;
        }

        public void SaveRecipe()
        {
            throw new NotImplementedException();
        }

        public void GetRecipeWithId(int id)
        {
            throw new NotImplementedException();
        }

        public async Task<RecipeResearchResponse> GetAllRecipes()
        {
            RecipeGrpcServiceClient client = new RecipeGrpcServiceClient(_grpcChannelService.OpenOrGet());
            RecipeResearchResponse recipes = await client.FindAllAsync(new Empty());
            return recipes;
        }
    }
}