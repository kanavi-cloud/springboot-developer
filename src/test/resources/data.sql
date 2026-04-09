INSERT INTO member (id, name) VALUES (1, 'name 1')
INSERT INTO member (id, name) VALUES (2, 'name 2')
INSERT INTO member (id, name) VALUES (3, 'name 3')
    // 1. 비영속 상태 (New)
    // 순수한 자바 객체 상태이며, 아직 JPA와 아무런 관련이 없습니다.
    Member member = new Member();
member.setId(100L);
member.setName("HelloJPA");

// 2. 영속 상태 (Managed)
// EntityManager를 통해 객체를 영속성 컨텍스트에 저장합니다.
// 이때 1차 캐시에 올라가며, 아직 DB에 INSERT 쿼리가 날아가지는 않습니다.
System.out.println("--- BEFORE PERSIST ---");
em.persist(member);
System.out.println("--- AFTER PERSIST ---");

// 3. 변경 감지 (Dirty Checking)
// 영속 상태인 객체의 값만 바꾸면?
// JPA가 트랜잭션 커밋 시점에 변경을 감지해서 자동으로 UPDATE 문을 실행합니다.
                                      member.setName("UpdatedJPA");

// 4. 준영속 상태 (Detached)
// 영속성 컨텍스트에서 특정 엔티티를 분리합니다.
// 이제부터는 값을 바꿔도 DB에 반영되지 않습니다.
em.detach(member);
member.setName("NoReflectName"); // 이 변경사항은 무시됨

// 5. 트랜잭션 커밋 (Flush 발생)
// 커밋하는 순간, 쌓여있던 SQL(INSERT, UPDATE 등)이 DB로 전송됩니다.
transaction.commit();