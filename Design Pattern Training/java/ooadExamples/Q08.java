//Improve code.
//Participant is a value object i.e. It is immutable.
class ParticipantsInDBTest extends TestCase {
    ParticipantsInDB p;
    void setUp() {
        p=ParticipantsInDB.getInstance();
    }
    void tearDown() {
        ParticipantsInDB.freeInstance();
    }
    void testAdd() {
        Participant part1=new Participant("ABC001","Kent",
            "Tong",true,"Manager");
        p.deleteAllParticipants();
        p.addParticipant(part1);
        assertEquals(p.getCount(),1);
    }
    void testAdd2() {
        Participant part1=new Participant("ABC001","Kent",
            "Tong",true,"Manager");
        Participant part2=new Participant("ABC003","Paul",
            "Chan",true,"Manager");
        p.deleteAllParticipants();
        p.addParticipant(part1);
        p.addParticipant(part2);
        assertEquals(p.getCount(),2);
    }
    void testEnum() {
        Participant part1=new Participant("ABC001","Kent","Tong",true,"Manager");
        Participant part2=new Participant("ABC003","Paul","Chan",true,"Manager");
        p.deleteAllParticipants();
        p.addParticipant(part2);
        p.addParticipant(part1);
        ParticipantEnumeratorById penum=new ParticipantEnumeratorById();
        assertTrue(penum.next());
        assertTrue(penum.get().equals(part1));
        assertTrue(penum.next());
        assertTrue(penum.get().equals(part2));
        assertTrue(!penum.next());
        penum.close();
    }
}
