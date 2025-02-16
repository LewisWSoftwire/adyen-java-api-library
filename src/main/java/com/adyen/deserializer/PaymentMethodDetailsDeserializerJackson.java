/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.deserializer;

import java.io.IOException;
import com.adyen.model.checkout.PaymentMethodDetails;
import com.adyen.model.checkout.details.AchDetails;
import com.adyen.model.checkout.details.AfterpayDetails;
import com.adyen.model.checkout.details.AmazonPayDetails;
import com.adyen.model.checkout.details.AndroidPayDetails;
import com.adyen.model.checkout.details.ApplePayDetails;
import com.adyen.model.checkout.details.BacsDirectDebitDetails;
import com.adyen.model.checkout.details.BillDeskOnlineDetails;
import com.adyen.model.checkout.details.BillDeskWalletDetails;
import com.adyen.model.checkout.details.BlikDetails;
import com.adyen.model.checkout.details.CardDetails;
import com.adyen.model.checkout.details.CellulantDetails;
import com.adyen.model.checkout.details.DokuDetails;
import com.adyen.model.checkout.details.DotpayDetails;
import com.adyen.model.checkout.details.DragonpayDetails;
import com.adyen.model.checkout.details.EcontextVoucherDetails;
import com.adyen.model.checkout.details.EntercashDetails;
import com.adyen.model.checkout.details.GiropayDetails;
import com.adyen.model.checkout.details.GooglePayDetails;
import com.adyen.model.checkout.details.IdealDetails;
import com.adyen.model.checkout.details.KlarnaDetails;
import com.adyen.model.checkout.details.LianLianPayDetails;
import com.adyen.model.checkout.details.MasterpassDetails;
import com.adyen.model.checkout.details.MbwayDetails;
import com.adyen.model.checkout.details.MobilePayDetails;
import com.adyen.model.checkout.details.MolPayDetails;
import com.adyen.model.checkout.details.PayPalDetails;
import com.adyen.model.checkout.details.PayUUpiDetails;
import com.adyen.model.checkout.details.PayWithGoogleDetails;
import com.adyen.model.checkout.details.QiwiWalletDetails;
import com.adyen.model.checkout.details.SamsungPayDetails;
import com.adyen.model.checkout.details.SepaDirectDebitDetails;
import com.adyen.model.checkout.details.StoredPaymentMethodDetails;
import com.adyen.model.checkout.details.UpiCollectDetails;
import com.adyen.model.checkout.details.UpiDetails;
import com.adyen.model.checkout.details.UpiIntentDetails;
import com.adyen.model.checkout.details.VippsDetails;
import com.adyen.model.checkout.details.VisaCheckoutDetails;
import com.adyen.model.checkout.details.WeChatPayDetails;
import com.adyen.model.checkout.details.WeChatPayMiniProgramDetails;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class PaymentMethodDetailsDeserializerJackson extends JsonDeserializer<PaymentMethodDetails> {

    @Override
    public PaymentMethodDetails deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        String type = node.get("type").asText();

        switch (type) {
            case AfterpayDetails.AFTERPAY_DEFAULT:
            case AfterpayDetails.AFTERPAYTOUCH:
            case AfterpayDetails.AFTERPAY_B2B:
                return codec.treeToValue(node, AfterpayDetails.class);
            case AchDetails.ACH:
                return codec.treeToValue(node, AchDetails.class);
            case AmazonPayDetails.AMAZONPAY:
                return codec.treeToValue(node, AmazonPayDetails.class);
            case AndroidPayDetails.ANDROIDPAY:
                return codec.treeToValue(node, AndroidPayDetails.class);
            case ApplePayDetails.APPLEPAY:
                return codec.treeToValue(node, ApplePayDetails.class);
            case BacsDirectDebitDetails.DIRECTDEBIT_GB:
                return codec.treeToValue(node, BacsDirectDebitDetails.class);
            case BillDeskOnlineDetails.BILLDESK_ONLINE:
                return codec.treeToValue(node, BillDeskOnlineDetails.class);
            case BillDeskWalletDetails.BILLDESK_WALLET:
                return codec.treeToValue(node, BillDeskWalletDetails.class);
            case BlikDetails.BLIK:
                return codec.treeToValue(node, BlikDetails.class);
            case CellulantDetails.CELLULANT:
                return codec.treeToValue(node, CellulantDetails.class);
            case DokuDetails.ALFAMART:
            case DokuDetails.BCA_VA:
            case DokuDetails.BNI_VA:
            case DokuDetails.BRI_VA:
            case DokuDetails.CIMB_VA:
            case DokuDetails.DANAMON_VA:
            case DokuDetails.INDOMARET:
            case DokuDetails.MANDIRI_VA:
            case DokuDetails.PERMATA_ATM:
            case DokuDetails.PERMATA_LITE_ATM:
            case DokuDetails.SINARMAS_VA:
                return codec.treeToValue(node, DokuDetails.class);
            case DotpayDetails.DOTPAY:
                return codec.treeToValue(node, DotpayDetails.class);
            case DragonpayDetails.EBANKING:
            case DragonpayDetails.OTC_BANKING:
            case DragonpayDetails.OTC_NON_BANKING:
            case DragonpayDetails.OTC_PHILIPPINES:
                return codec.treeToValue(node, DragonpayDetails.class);
            case EcontextVoucherDetails.SEVENELEVEN:
            case EcontextVoucherDetails.STORES:
                return codec.treeToValue(node, EcontextVoucherDetails.class);
            case EntercashDetails.ENTERCASH:
                return codec.treeToValue(node, EntercashDetails.class);
            case GiropayDetails.GIROPAY:
                return codec.treeToValue(node, GiropayDetails.class);
            case GooglePayDetails.GOOGLEPAY:
                return codec.treeToValue(node, GooglePayDetails.class);
            case PayWithGoogleDetails.PAYWITHGOOGLE:
                return codec.treeToValue(node, PayWithGoogleDetails.class);
            case IdealDetails.IDEAL:
                return codec.treeToValue(node, IdealDetails.class);
            case KlarnaDetails.KLARNA:
            case KlarnaDetails.KLARNA_ACCOUNT:
            case KlarnaDetails.KLARNA_B2B:
            case KlarnaDetails.KLARNA_PAY_NOW:
            case KlarnaDetails.KLARNA_PAYMENTS:
            case KlarnaDetails.KLARNA_PAYMENTS_ACCOUNT:
            case KlarnaDetails.KLARNA_PAYMENTS_B2B:
                return codec.treeToValue(node, KlarnaDetails.class);
            case LianLianPayDetails.EBANKING_CREDIT:
            case LianLianPayDetails.EBANKING_DEBIT:
            case LianLianPayDetails.EBANKING_ENTERPRISE:
                return codec.treeToValue(node, LianLianPayDetails.class);
            case MasterpassDetails.MASTERPASS:
                return codec.treeToValue(node, MasterpassDetails.class);
            case MbwayDetails.MBWAY:
                return codec.treeToValue(node, MbwayDetails.class);
            case MobilePayDetails.MOBILEPAY:
                return codec.treeToValue(node, MobilePayDetails.class);
            case MolPayDetails.EBANKING_DIRECT_MY:
            case MolPayDetails.EBANKING_FPX_MY:
            case MolPayDetails.EBANKING_MY:
            case MolPayDetails.EBANKING_TH:
            case MolPayDetails.EBANKING_VN:
            case MolPayDetails.FPX:
                return codec.treeToValue(node, MolPayDetails.class);
            case PayPalDetails.PAYPAL:
                return codec.treeToValue(node, PayPalDetails.class);
            case PayUUpiDetails.PAYUINUPI:
                return codec.treeToValue(node, PayUUpiDetails.class);
            case QiwiWalletDetails.QIWIWALLET:
                return codec.treeToValue(node, QiwiWalletDetails.class);
            case SamsungPayDetails.SAMSUNGPAY:
                return codec.treeToValue(node, SamsungPayDetails.class);
            case SepaDirectDebitDetails.SEPADIRECTDEBIT_AMAZONPAY:
            case SepaDirectDebitDetails.SEPADIRECTDEBIT:
                return codec.treeToValue(node, SepaDirectDebitDetails.class);
            case UpiDetails.UPI:
                return codec.treeToValue(node, UpiDetails.class);
            case UpiCollectDetails.UPI_COLLECT:
                return codec.treeToValue(node, UpiCollectDetails.class);
            case UpiIntentDetails.UPI_INTENT:
                return codec.treeToValue(node, UpiIntentDetails.class);
            case VippsDetails.VIPPS:
                return codec.treeToValue(node, VippsDetails.class);
            case VisaCheckoutDetails.VISA_CHECKOUT:
                return codec.treeToValue(node, VisaCheckoutDetails.class);
            case WeChatPayDetails.WECHATPAY:
                return codec.treeToValue(node, WeChatPayDetails.class);
            case WeChatPayMiniProgramDetails.WECHATPAYMINIPROGRAM:
                return codec.treeToValue(node, WeChatPayMiniProgramDetails.class);
            case StoredPaymentMethodDetails.BCMC_MOBILE:
            case StoredPaymentMethodDetails.BCMC_MOBILE_QR:
            case StoredPaymentMethodDetails.BCMC_MOBILE_APP:
            case StoredPaymentMethodDetails.MOMO_WALLET:
            case StoredPaymentMethodDetails.MOMO_WALLET_APP:
            case StoredPaymentMethodDetails.PAYMAYA_WALLET:
            case StoredPaymentMethodDetails.GRABPAY_SG:
            case StoredPaymentMethodDetails.GRABPAY_MY:
            case StoredPaymentMethodDetails.GRABPAY_TH:
            case StoredPaymentMethodDetails.GRABPAY_ID:
            case StoredPaymentMethodDetails.GRABPAY_VN:
            case StoredPaymentMethodDetails.GRABPAY_PH:
            case StoredPaymentMethodDetails.OXXO:
            case StoredPaymentMethodDetails.GCASH:
            case StoredPaymentMethodDetails.KAKAOPAY:
            case StoredPaymentMethodDetails.TRUEMONEY:
                return codec.treeToValue(node, StoredPaymentMethodDetails.class);
            default:
                return codec.treeToValue(node, CardDetails.class);
        }
    }
}
