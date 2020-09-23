using System;

namespace Com.Example.Game.Scripts.Test
{
    public class TestService : ITestService
    {
        public void DoSomething()
        {
            Console.WriteLine("I am doing Something");
        }

        public void DoTerminate()
        {
            Console.WriteLine("I am terminating Something");
        }
    }
}