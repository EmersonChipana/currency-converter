package arquitectura.software.demo.dao.repository

import arquitectura.software.demo.dao.Currency
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface CurrencyRepository: PagingAndSortingRepository<Currency, Long>
