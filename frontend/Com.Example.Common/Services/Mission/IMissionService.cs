namespace Com.Example.Common.Services
{
    public interface IMissionService
    {
        void StartMission();
        
        void EndMission();
        
        void SaveMission();

        void GetMissionWithId(int id);
    }
}