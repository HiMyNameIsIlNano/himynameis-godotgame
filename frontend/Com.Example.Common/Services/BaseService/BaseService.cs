using System;

namespace Com.Example.Common.Services.BaseService
{
    public class BaseService : IBaseService
    {
        public void doSomeBasicStuff()
        {
            Console.WriteLine("I am doing something basic!");
        }
    }
}