namespace Com.Example.Common.Services.BaseService
{
    public class ConcreteService : IConcreteService
    {
        private IBaseService _baseService { get; set; }

        public ConcreteService(IBaseService baseService)
        {
            this._baseService = baseService;
        }

        public void DoConcreteStuff()
        {
            _baseService.doSomeBasicStuff();
        }
    }
}