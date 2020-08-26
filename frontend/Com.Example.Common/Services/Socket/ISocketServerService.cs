using System.Threading.Tasks;


namespace Com.Example.Common.Services.Socket
{
    public interface ISocketServerService
    {
        Task ClientCanConnectToServer();
    }
}