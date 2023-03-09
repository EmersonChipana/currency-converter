package arquitectura.software.demo.api

import arquitectura.software.demo.bl.CurrencyBl
import arquitectura.software.demo.dto.ResponseServiceDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.math.BigInteger
import java.security.Principal

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

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    fun user(): String {
        LOGGER.info("Iniciando servicio user")
        return "ROLE_USER"
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    fun admin(): String {
        LOGGER.info("Iniciando servicio admin")
        return "ROLE_ADMIN"
    }

    @GetMapping("/principal")
    fun info(principal: Principal): String {
        return principal.toString()
    }

}