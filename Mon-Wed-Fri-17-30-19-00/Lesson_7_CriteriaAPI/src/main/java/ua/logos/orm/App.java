		//Об’єкт який дозволяє будувати динамічні запити
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		//Об’єкт запиту параметризований під тип данних що 
		//буде повернено в результаті виконання
		CriteriaQuery<Course> query = cb.createQuery(Course.class);
		//Об’єкт який являється блоком FROM в запиті
		//Ця частина ідентична частині запиту на JPQL 
		//FROM Course i 
		Root<Course> root = query.from(Course.class); 
		//Це звичайний селект, ідентично SELECT c 
 		query.select(root); 
		
 		//Після стрічки вище маємо ось такий запит
 		//SELECT c FROM Course c -- який поверне всі курси з БД
 	    //Тепер потрібно створити умови по яким ми будемо 
 		//фільтрувати товари
 		//Expression - це об’єкт виразу в блоці WHERE
 		//Даний вираз означає наступне с.price
 		Expression<BigDecimal> priceExpression = root.get("price");
 		
 		//Predicate - це вже умова пошуку
 		//Є декілька варіантів як її створити
 		//більшість цих варіантів являється методами CriteriaBuilder
 		//цей метод робить наступну умову greater than or equal
 		//тепер у нас є умова WHERE c.price >= 15.99
 		Predicate pricePredicate = cb.ge(priceExpression, new BigDecimal("15.99"));
 		
 		// Ще одна умова - less than or equal WHERE c.price <= 19.99
 		Predicate pricePredicate2 = cb.le(priceExpression, new BigDecimal("19.99"));
 		
 		//Тепер в нас є 2 умови:
 		//WHERE c.price >= 15.99
 		//WHERE c.price <= 19.99
 		//а потрібно все в одному блоці з оператором AND
 		//CriteriaBuilder знову має метод який 
 		//підходить для даної затачі
 		//він приймає будь-яку кількість об’єктів Predicate
 		//передаємо туди всі що є
 		//отримаємо один десь такий:
 		// WHERE c.price >= 15.99 AND WHERE c.price <= 19.99
 		Predicate allPredicates = cb.and(pricePredicate, pricePredicate2); 		
  		// query.where(allPredicates);
 		
 		Expression<Long> betweenId = root.get("id");
 		Predicate predicateId = cb.between(betweenId, new Long(5), new Long(15));
 		// query.where(predicateId);
 		
 		Expression<String> titleExpression = root.get("title");
 		Predicate titlePredicate = cb.like(titleExpression, "%2");
 		
 		Expression<Long> idExpressionLong = root.get("id");
 		Predicate idExpressionPredicate = cb.ge(idExpressionLong, new Long(10));	
 		Predicate allLikePredicates = cb.and(titlePredicate, idExpressionPredicate);
 		// query.where(allLikePredicates);
 		
 		//Якщо умова вимагає пошуку в інших таблицях
 		//потрібно зробити JOIN
 		//Як і все в Criteria API це також об’єкт
 		//який можна отримати викликавши метод .join(String field)
 		//від об’єкту Root, цим ми змінили блок FROM до такого вигляду
 		//FROM Course c JOIN c.teacher t
 		Join<Course, Teacher> teacherjoin = root.join("teacher");
 		//Це вираз WHERE t.id = 5
 		Expression<Long> teacherIdJoin = teacherjoin.get("id"); 
 		Predicate teacherIdPredicate = cb.equal(teacherIdJoin, new Long(5));

 		query.where(teacherIdPredicate);
 		//JOIN і FETCH в Criteria API це різні речі
 		//і якщо ви хочете зробити fetch
 		//потрібно його викликати окремо не зважаючи на всі інші JOIN
 		root.fetch("teacher");
 		query.distinct(true);
		
 		List<Course> courses = em.createQuery(query).getResultList();
		courses.forEach(c -> System.out.println(c));
