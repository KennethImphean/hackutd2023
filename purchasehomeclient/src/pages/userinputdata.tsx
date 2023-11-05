import Image from 'next/image';
import Head from 'next/head';
import Navbar from './components/navbar';

const Userinputdata = () => {
  return (
    <>
      <Head>
        <title>Home Pre-Approval User-Input Data</title>
        <meta name="description" content="User-Input Data"></meta>
      </Head>
      <h1 className="text-3xl font-bold">
        <Navbar/>
      </h1>
    </>
  )
};
export default Userinputdata;