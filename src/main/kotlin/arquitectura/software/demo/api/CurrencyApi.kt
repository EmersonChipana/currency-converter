package arquitectura.software.demo.api

import arquitectura.software.demo.bl.CurrencyBl
import arquitectura.software.demo.dao.Currency
import arquitectura.software.demo.dto.ResponseServiceDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RequestMapping("/api/currency")
@RestController
class CurrencyApi @Autowired constructor(private val currencyBl: CurrencyBl) {

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(CurrencyApi::class.java)
    }

    @GetMapping("/exchange")
    fun exchangeRate(@RequestParam to: String,
                     @RequestParam from: String,
                     @RequestParam amount: BigDecimal): ResponseServiceDto {
        LOGGER.info("Iniciando peticion para convertir divisas de $from a $to con un monto de $amount")
        val result = currencyBl.exchangeRate(to, from, amount)
        return result
    }

    @GetMapping("/list")
    fun getConvertions(
        @RequestParam page: Int,
        @RequestParam size: Int) : ResponseEntity<PageImpl<Currency>> {
        val convertions = currencyBl.getConvertions(page, size);
        return ResponseEntity.ok(convertions)
    }

}