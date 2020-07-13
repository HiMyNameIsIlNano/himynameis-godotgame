using System;
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

            RecipeResearchResponse recipes = client.FindAll(new Empty());
            recipes.Recipes.ToList().ForEach(dto => Console.WriteLine(dto.Name));

            channel.ShutdownAsync().Wait();
            Console.WriteLine("Press any key to exit...");
            Console.ReadKey();
        }
    }
}