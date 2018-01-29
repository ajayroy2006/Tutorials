class ParticipantsInDBTest extends TestCase {
    ParticipantsInDB p;
    void setUp() {
        p=ParticipantsInDB.getInstance();
    }
    void tearDown() {
        ParticipantsInDB.freeInstance();
    }
    Participant part1=new Participant("ABC001","Kent",
            "Tong",true,"Manager");
    Participant part2=new Participant("ABC003","Paul",
            "Chan",true,"Manager");
    void testAdd() {
        p.deleteAllParticipants();
        p.addParticipant(part1);
        assertEquals(p.getCount(),1);
    }
    void testAdd2() {
        p.deleteAllParticipants();
        p.addParticipant(part1);
        p.addParticipant(part2);
        assertEquals(p.getCount(),2);
    }
    void testEnum() {
        p.deleteAllParticipants();
        p.addParticipant(part2);
        p.addParticipant(part1);
        ParticipantEnumeratorById penum=null;
        try {
            new ParticipantEnumeratorById();
            assertTrue(penum.next());
            assertTrue(penum.get().equals(part1));
            assertTrue(penum.next());
            assertTrue(penum.get().equals(part2));
            assertTrue(!penum.next());
        } finally {
            penum.close();
        }
    }
}
